#!/bin/sh

res="../Benchmarks"
java -jar target/benchmarks.jar Benchmark -rf JSON -rff ${res}.json -wi 2 -f 1 -i 5 | tee ${res}.txt
