
###### 2019-03-12

## SUMO 問題

#### 問題一：
1.目前要抓取**vehicle**值時，會從net.xml中抓取position時，將會回傳該模擬地圖的座標，但是這會出現問題，因為實際要應該回傳的是vehicle的**經緯度(lon, lat)**

看到網路上也有相似提問，

> 1)  Could you suggest how to get latitude and longitude coordinates of the vehicles instead of sumo x,y-coordinates?More specific details about what I would like to do:In the tripinfo file output from the simulation, it gives destinations of all vehicles in term of arrivalLane and arrivalPos. But I would like to know those destinations in term of latitude and longitude. 

> 2) Is there an equation to convert sumo x,y-coordinates to lat/lon-coordinates?

#### 解法一

- 1) you can run sumo with the option 

> —fcd-output fcd.xml --fcd-output.geo

- for a complete trace of vehicle positions along their route (including start and end points)

- 2) you can do coordinate transformations using traci (this can also be done
after the acutal simulation is finished by **simpy** loading the network and doing coordiate queries). 

- see [position conversion (0x82)](http://sumo-sim.org/wiki/TraCI/Simulation_Value_Retrieval#Command_0x82:_Position_Conversion) //Reads a position information and returns it converted into the given representation.

- you can do coordinate transformations using sumolib (requires pyproj
python module). 

- In the source code you will also find the formula.
  see http://sumo-sim.org/wiki/Tools/Sumolib

- the functions are **sumolib.net.convertLonLat2XY** and
**sumolib.net.convertXY2LonLat**

- Implementing the function **sumolib.net.convertLanePos2XY** is left as an
exercise for the reader (but be sure to send a patch if you do).

### coordinate transformations



```python
 net = sumolib.net.readNet('myNet.net.xml')

 # network coordinates (lower left network corner is at x=0, y=0)

 x, y = net.convertLonLat2XY(lon, lat)

 lon, lat = net.convertXY2LonLat(x, y)

 # raw UTM coordinates

 x, y = net.convertLonLat2XY(lon, lat, True)

 lon, lat = net.convertXY2LonLat(x, y, True)
```