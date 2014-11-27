TimeWaster
==========
Just for fun!

###### Averages

Default version takes about 260 to 275 ms over an average of 300 attempts. Using arrays (And avoiding a lot of heap allocations) that can be improved to about an average of 53ms over 300 attempts. Then adding another 7 threads to mix allows the max to be pushed to an average of 8 to 9 ms over 300 attempts.

###### How to run on OS X
```
curl -o TimeWaster.class https://raw.githubusercontent.com/Koenkk/TimeWaster/master/TimeWaster.class
java TimeWaster
```

###### How to run on Linux
```
wget https://raw.githubusercontent.com/Koenkk/TimeWaster/master/TimeWaster.class
java TimeWaster


```
