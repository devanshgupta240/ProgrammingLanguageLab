import Data.List ()
import System.IO ()

-- function for removing duplicate from list
removeDuplicates :: (Eq a) => [a] -> [a]
removeDuplicates [] = []
removeDuplicates (x:xs)
    | x `elem` xs = removeDuplicates xs
    | otherwise = x : removeDuplicates xs

-- addtion on setA and setB
add ::(Eq a,Num a) => [a] -> [a] -> [a]
add [] [] = []
add set [] = []
add [] set = []
add setA setB = removeDuplicates([x + y |x <- setA, y <- setB])

-- substraction on setA and setB
sub ::(Eq a) => [a] -> [a] -> [a]
sub [] [] = []
sub set [] = set
sub [] set = []
sub (x:xs) y
    | x `elem` y = sub xs y
    | otherwise = x : sub xs y

-- union of setA and setB
union :: (Eq a) => [a] -> [a] -> [a]
union [] [] = []
union set [] = set
union [] set = set
union setA setB = removeDuplicates (setA ++ setB)

-- intersection of setA and setB
inter ::(Eq a) => [a] -> [a] -> [a]
inter [] [] = []
inter set [] = []
inter [] set = []
inter (x:xs) y
    | x `elem` y = x : inter xs y
    | otherwise = inter xs y 

-- 
setA = [1,2,30,4,7,22]
setB = [3,40,9]

-- perform various operations on setA and setB
performAddition = do
    putStrLn("SetA  " ++ show(setA))
    putStrLn("SetB  " ++ show(setB))
    putStrLn("")
    putStrLn("Addition on SetA and SetB  " ++ show(add setA setB))

performSubstraction = do
    putStrLn("SetA  " ++ show(setA))
    putStrLn("SetB  " ++ show(setB))
    putStrLn("")
    putStrLn("Substraction on SetA and SetB  " ++ show(sub setA setB))

performUnion = do
    putStrLn("SetA  " ++ show(setA))
    putStrLn("SetB  " ++ show(setB))
    putStrLn("")
    putStrLn("Union on SetA and SetB  " ++ show(union setA setB))

performIntersection = do
    putStrLn("SetA  " ++ show(setA))
    putStrLn("SetB  " ++ show(setB))
    putStrLn("")
    putStrLn("Intersection on SetA and SetB  " ++ show(inter setA setB))

performNullCheck = do
    putStrLn("")
    putStrLn("SetA  " ++ show(setA))
    putStrLn( "Is setA is NULL?  " ++ show(null setA))
    putStrLn("")
    putStrLn("SetB  " ++ show(setB))
    putStrLn( "Is setB is NULL?  " ++ show(null setB))
    putStrLn("")