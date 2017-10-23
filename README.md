[![Build Status](https://travis-ci.org/speedlog/mapping-tools-performance.svg?branch=master)](https://travis-ci.org/speedlog/mapping-tools-performance)

# Compare performance Dozer vs MapStruct

This little project tests performance of mapping using Dozer and MapStruct.
First it creates 1 000 000 objects "Worker" and than using each library maps it into "WorkerInfo" objects.

## Test results

Running on my notebook:
* Intel® Core™ i7-3630QM CPU @ 2.40GHz × 8 
* 16GB RAM
* SDD
* Ubuntu 15.10 (64-bit)
* Java(TM) SE Runtime Environment (build 1.8.0_72-b1)

```
INFO  Main:36 - Preparing sample data...
INFO  Main:43 - Done preparing sample data in 2.59300 seconds
INFO  Main:61 - Start mapping with MapStruct...
INFO  Main:68 - Mapping with MapStruct done in 3.51100 seconds
INFO  Main:48 - Start mapping with Dozer...
INFO  Main:56 - Mapping with Dozer done in 16.28200 seconds
```

## Comparison points are here:


| Points        | Dozer           | MapStruct  |
| :------------- |:-------------| :-----|
| Description | Mapping rules are defined in XML files, which are then loaded during application runtime. Dozer is using reflection mechanism for mapping | Mapping rules are defined in Java files, mostly in annotations. Based on this rules MapStruct generates Java classes, which are then used for mapping |
| Speed | Dozer uses reflection mechanism for mapping, which means it is slower than MapStruct. In example (link) it is mapped 1 000 000 objects. On my notebook it takes about 16 seconds | MapStruct invoke methods of classes, which were generated before compilation. Thanks to that it works faster than Dozer. In example (link) it is mapped 1 000 000 objects. On my notebook it takes about 3 seconds. #### MapStruct is about 500% faster than Dozer |
| Security | When you make a mistake in XML that contains mapping rules you will know about it only during invoking mapping (runtime error).|When you make a mistake in property name, you will know about it during compilation. Thanks that application will be more reliable|
| Immutable objects | Dozer can access private properties (by reflection). It makes possible to map immutable objects which haven’t setters. It requires that immutable object has a constructor without parameters and in mapping files you should add attribute is-accessible="true" to destination fields | Unfortunately MapStruct hasn’t ability to map immutable objects. There is an open issue(https://github.com/mapstruct/mapstruct/issues/73) about that.|
| Debugging | Mapping rules are defined mostly in XML files. During application runtime that files are loaded. Thus debugging mapping process is difficult – you have to set breakpoints in Dozer classes | You can set breakpoint in classes, which was generated during compilation. Thanks that you can easily determine which classes are used for mapping and debug them. |
| Popularity (as at the date 23.03.2016) | Creation date: 04.06.2005  Stackoverflow: 1610 postów  Github: https://github.com/DozerMapper/dozer  Last release date: 22.04.2014 | Creation date: 22.05.2012  Stackoverflow: 108 postów  Github: https://github.com/mapstruct/mapstruct  Last release date: 16.03.2016 |
| Debugging | Mapping rules are defined mostly in XML files. During application runtime that files are loaded. Thus debugging mapping process is difficult – you have to set breakpoints in Dozer classes. | You can set breakpoint in classes, which was generated during compilation. Thanks that you can easily determine which classes are used for mapping and debug them.|
| Additional advantages | nothing special | a. More default mapping for example: Joda-Time, JAXBElement   b. Mapping code only in Java files – faster determination, which code is responsible for data mapping.   c. Event handling (@BeforeMapping, @AfterMapping)   d. Built-in support for decorators |


## Run it locally

`mvn install exec:java -pl mapper -DskipTests`

## More information Dozer vs MapStruct
http://mariusz.wyszomierski.pl/en/mapping-dozer-vs-mapstruct/
