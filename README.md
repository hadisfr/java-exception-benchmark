# Java Exception Benchmark

a set of jmh benchmarks
to investigate performance impact of
`Exception`s in Java 

## Results

| Benchmark                      | Mode   | Cnt     | Score    | Error    | Units |
| ------------------------------ | ------ | ------- | -------- | -------- | ----- |
| baseline                       | sample | 1133198 | 44.736   | ±  0.863 | ns/op |
| groundTest                     | sample | 1896757 | 51.505   | ±  0.693 | ns/op |
| oneDepthExceptionTest          | sample | 1118895 | 1778.152 | ± 14.438 | ns/op |
| oneDepthGroundTest             | sample | 1838499 | 51.942   | ±  1.285 | ns/op |
| oneDepthWithTryCatchGroundTest | sample | 1836940 | 60.143   | ±  3.258 | ns/op |
| simplifiedGroundTest           | sample | 1779411 | 62.229   | ±  3.044 | ns/op |
| twoDepthExceptionTest          | sample | 1742896 | 1943.462 | ± 44.310 | ns/op |
| zeroDepthExceptionTest         | sample | 1664964 | 1807.943 | ± 19.644 | ns/op |

![benchmarks](benchmarks.png)

Graphs are generated using [JMH Visualizer](https://jmh.morethan.io/).
