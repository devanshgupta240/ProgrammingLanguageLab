bus(123,amingaon,jalukbari,12,12.2,30,10).
bus(123,jalukbari,maligaon,12.2,15,110,10).
bus(123,maligaon,lokhra,15,15.5,50,10).
bus(123,lokhra,chandmari,15.5,16,50,10).
bus(153,amingaon,paltanbazar,14.5,14.6,10,20).
bus(153,paltanbazar,maligaon,14.7,14.8,10,20).
bus(153,maligaon,chandmari,14.9,15.2,20,20).
bus(327,amingaon,maligaon,14,14.2,100,30).
bus(327,maligaon,chandmari,14.2,14.5,100,30).
bus(832,amingaon,chandmari,14,17,30,40).
visited(Vis):-
  \+(\+(Vis=0)),
  \+(\+(Vis=1)).
findDistCostTimeX_Y(X,Y,DepartureTime,ArrivalTime,Distance,Time,Cost,B):- bus(B,X,Y,DepartureTime,ArrivalTime,Distance,Cost), is(Time,-(ArrivalTime,DepartureTime)).

findPath(X,Y,[X,Y],Prev,Distance,Time,Cost,[B]):- visited(Prev),findDistCostTimeX_Y(X,Y,_,_,Distance,Time,Cost,B).
findPath(X,Y,[X,Y],Prev,Distance,Time,Cost,[B]):- \+(visited(Prev)),findDistCostTimeX_Y(X,Y,DepartureTime,_,Distance,Time,Cost,B),DepartureTime>=Prev.
findPath(X,Y,[X|A],_,Distance,Time,Cost,[B1|Bus]):- findDistCostTimeX_Y(X,Z,_,Arr1,DistancePrev,TimePrev,CostPrev,B1),findPath(Z,Y,A,Arr1,DistanceNext,TimeNext,CostNext,Bus), is(Distance,+(DistancePrev+DistanceNext)),is(Time,+(TimePrev+TimeNext)),is(Cost,+(CostPrev+CostNext)).

optDistPath(X,X,[X],[],0,0,0):- !.
optDistPath(X,Y,PathDist,BusDist,MinDist,TimeDist,CostDist):-
    findall([Distance,P,B,Time,Cost],findPath(X,Y,P,_,Distance,Time,Cost,B),Set),
    sort(Set,Sorted),
    Sorted = [[MinDist,PathDist,BusDist,TimeDist,CostDist]|_].

optTimePath(X,X,[X],[],0,0,0):- !.
optTimePath(X,Y,PathTime,BusTime,DistTime,MinTime,CostTime):-
    findall([Time,P,B,Distance,Cost],findPath(X,Y,P,_,Distance,Time,Cost,B),Set),
    sort(Set,Sorted),
    Sorted = [[MinTime,PathTime,BusTime,DistTime,CostTime]|_].

optCostPath(X,X,[X],[],0,0,0):- !.
optCostPath(X,Y,PathCost,BusCost,DistCost,TimeCost,MinCost):-
    findall([Cost,P,B,Distance,Time],findPath(X,Y,P,_,Distance,Time,Cost,B),Set),
    sort(Set,Sorted),
    Sorted = [[MinCost,PathCost,BusCost,DistCost,TimeCost]|_].

route(X,Y):-
    optDistPath(X,Y,PathDist,BusDist,MinDist,TimeDist,CostDist),
    write("Optimum Distance:"),nl,
    write("Path="),write(PathDist),nl,
    write("Buses="),write(BusDist),nl,
    write("Distance="),write(MinDist),
    write(",Time="),write(TimeDist),
    write(" ,Cost="),write(CostDist),nl,
    optTimePath(X,Y,PathTime,BusTime,DistTime,MinTime,CostTime),
    write("Optimum Time:"),nl,
    write("Path="),write(PathTime),nl,
    write("Buses="),write(BusTime),nl,
    write("Distance="),write(DistTime),
    write(" ,Time="),write(MinTime),
    write(" ,Cost="),write(CostTime),nl,
    optCostPath(X,Y,PathCost,BusCost,DistCost,TimeCost,MinCost),
    write("Optimum Cost:"),nl,
    write("Path="),write(PathCost),nl,
    write("Buses="),write(BusCost),nl,
    write("Distance="),write(DistCost),
    write(" ,Time="),write(TimeCost),
    write(" ,Cost="),write(MinCost);
    write("Please enter the correct source and destination!").