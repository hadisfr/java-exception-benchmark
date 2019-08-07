# Java Exception Benchmark

a set of jmh benchmarks
to investigate performance impact of
`Exception`s in Java 

## Results

### Local

| Benchmark                                   | Mode   | Cnt     | Score    | Error    | Units |
| ------------------------------------------- | ------ | ------- | -------- | -------- | ----- |
| Benchmarks.baselin                          | sampl  | 113405  | 46.76    | ±   2.20 | ns/op |
| Benchmarks.createNewExceptionObjectTes      | sampl  | 166654  | 2081.74  | ±  67.57 | ns/op |
| Benchmarks.groundTes                        | sampl  | 190195  | 49.54    | ±   0.86 | ns/op |
| Benchmarks.oneDepthExceptionTes             | sampl  | 186578  | 1735.26  | ±   7.20 | ns/op |
| Benchmarks.oneDepthGroundTes                | sampl  | 177015  | 74.46    | ±  11.70 | ns/op |
| Benchmarks.oneDepthWithTryCatchGroundTes    | sampl  | 163206  | 116.62   | ±  48.16 | ns/op |
| Benchmarks.simplifiedGroundTes              | sampl  | 175213  | 79.57    | ±  17.45 | ns/op |
| Benchmarks.twoDepthExceptionTes             | sampl  | 167591  | 2086.26  | ±  69.70 | ns/op |
| Benchmarks.twoDepthWithRethrowExceptionTes  | sampl  | 166684  | 2355.16  | ± 290.36 | ns/op |
| Benchmarks.twoDepthWithThrowNewExceptionTes | sampl  | 166231  | 4080.05  | ± 144.07 | ns/op |
| Benchmarks.zeroDepthExceptionTes            | sampl  | 153326  | 2046.24  | ±  68.77 | ns/op |


![benchmarks](local.png)

### Remote

| Benchmark                      | Mode   | Cnt     | Score    | Error    | Units |
| ------------------------------ | ------ | ------- | -------- | -------- | ----- |
| baseline                       | sample | 1208386 | 30.271   | ±  0.520 | ns/op |
| groundTest                     | sample | 1305941 | 32.524   | ±  0.480 | ns/op |
| oneDepthExceptionTest          | sample | 1493518 | 2131.185 | ± 17.366 | ns/op |
| oneDepthGroundTest             | sample | 1350835 | 32.968   | ±  0.207 | ns/op |
| oneDepthWithTryCatchGroundTest | sample | 1337843 | 32.268   | ±  1.782 | ns/op |
| simplifiedGroundTest           | sample | 1318212 | 34.155   | ±  0.275 | ns/op |
| twoDepthExceptionTest          | sample | 1502476 | 2109.329 | ± 13.050 | ns/op |
| zeroDepthExceptionTest         | sample | 1482144 | 2171.963 | ± 73.848 | ns/op |

![benchmarks](remote.png)

Graphs are generated using [JMH Visualizer](https://jmh.morethan.io/).

## Conclusion

Generation of any new object of `Throwable` class has got about 2 us overhead.
