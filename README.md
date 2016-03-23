[![Build Status](https://travis-ci.org/speedlog/mapping-tools-performance.svg?branch=master)](https://travis-ci.org/speedlog/mapping-tools-performance)
# Compare performence Dozer vs MapStruct

This little project tests performence of mapping using Dozer and MapStruct.
First it creates 1 000 000 objects "Worker" and than using each library maps it into "WorkerInfo" objects.

## Test results

Running on my notebook:
# Intel® Core™ i7-3630QM CPU @ 2.40GHz × 8 
# 16GB RAM
# SDD
# Ubuntu 15.10 (64-bit)
# Java(TM) SE Runtime Environment (build 1.8.0_72-b1)

```
INFO  Main:36 - Preparing sample data...
INFO  Main:43 - Done preparing sample data in 2.59300 seconds
INFO  Main:61 - Start mapping with MapStruct...
INFO  Main:68 - Mapping with MapStruct done in 3.51100 seconds
INFO  Main:48 - Start mapping with Dozer...
INFO  Main:56 - Mapping with Dozer done in 16.28200 seconds
```

## Run it locally

`mvn install exec:java -pl mapper -DskipTests`

## More information Dozer vs MapStruct
http://mariusz.wyszomierski.pl/en/mapping-dozer-vs-mapstruct/
