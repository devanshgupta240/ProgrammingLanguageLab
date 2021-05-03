parent(jatin,avantika).
parent(jolly,jatin).
parent(jolly,katappa).
parent(manisha,avantika).
parent(manisha,shivkami).
parent(bahubali,shivkami).
male(bahubali).
male(katappa).
male(jolly).
female(shivkami).
female(avantika).

brother(X, Y) :-male(X),parent(Z,X),parent(Z,Y),not(X=Y).
uncle(X, Y) :-brother(X,Z),parent(Z,Y).
halfsister(X, Y) :-female(X),dif(X,Y),parent(Z, X),parent(Z, Y),parent(A,Y),parent(B,Y),dif(A,B),dif(A,Z).