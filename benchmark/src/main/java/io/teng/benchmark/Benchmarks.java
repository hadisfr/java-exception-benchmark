package io.teng.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Benchmarks {

    private int one = 1;

    @Benchmark
    public void baseline() {
    }

    @Benchmark
    public boolean simplifiedGroundTest() {
        return one == 1;
    }

    @Benchmark
    public boolean groundTest() {
        if (one == 1)
            return true;
        return false;
    }

    @Benchmark
    public boolean zeroDepthExceptionTest() {
        try {
            if (one == 1)
                throw new IllegalArgumentException("one == 1");
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Benchmark
    public boolean oneDepthExceptionTest() {
        try {
            return zeroDepthException();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Benchmark
    public boolean oneDepthGroundTest() {
        return groundTest();
    }

    @Benchmark
    public boolean oneDepthWithTryCatchGroundTest() {
        try {
            return groundTest();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Benchmark
    public boolean twoDepthExceptionTest() {
        try {
            return oneDepthException();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean zeroDepthException() {
        if (one == 1)
            throw new IllegalArgumentException("one == 1");
        return true;
    }

    private boolean oneDepthException() {
        return zeroDepthException();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmarks.class.getSimpleName())
                .warmupIterations(2)
                .measurementIterations(5)
                .forks(1)
                .resultFormat(ResultFormatType.JSON)
                .result(String.format("%s.json", Benchmarks.class.getSimpleName()))
                .build();

        new Runner(opt).run();
    }
}
