-- remove duplicate area dimensions
eliminateRepeated2 list dim1 dim2 = elmRepeated2 list [] dim1 dim2
elmRepeated2 [] _ _ _= []
elmRepeated2 ((dim_bedroom,dim_hall):xs) list2 dim1 dim2
    | (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2))  `elem` list2) = elmRepeated2 xs list2 dim1 dim2
    | otherwise = (dim_bedroom,dim_hall) : elmRepeated2 xs (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)):list2) dim1 dim2

eliminateRepeated3 list dim1 dim2 dim3 = elmRepeated3 list [] dim1 dim2 dim3
elmRepeated3 [] _ _ _ _= []
elmRepeated3 ((dim_bedroom,dim_hall,dim_kitchen):xs) list2 dim1 dim2 dim3
    | (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3))  `elem` list2) = elmRepeated3 xs list2 dim1 dim2 dim3
    | otherwise = (dim_bedroom,dim_hall,dim_kitchen) : elmRepeated3 xs (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)):list2) dim1 dim2 dim3

eliminateRepeated4 list dim1 dim2 dim3 dim4 = elmRepeated4 list [] dim1 dim2 dim3 dim4
elmRepeated4 [] _ _ _ _ _= []
elmRepeated4 ((dim_bedroom,dim_hall,dim_kitchen,dim_bathroom):xs) list2 dim1 dim2 dim3 dim4
    | (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4))  `elem` list2) = elmRepeated4 xs list2 dim1 dim2 dim3 dim4
    | otherwise = (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom) : elmRepeated4 xs (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)):list2) dim1 dim2 dim3 dim4

eliminateRepeated5 list dim1 dim2 dim3 dim4 dim5 = elmRepeated5 list [] dim1 dim2 dim3 dim4 dim5
elmRepeated5 [] _ _ _ _ _ _= []
elmRepeated5 ((dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden):xs) list2 dim1 dim2 dim3 dim4 dim5
    | (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)+(fst(dim_garden)*snd(dim_garden)*dim5))  `elem` list2) = elmRepeated5 xs list2 dim1 dim2 dim3 dim4 dim5
    | otherwise = (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden) : elmRepeated5 xs (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)+(fst(dim_garden)*snd(dim_garden)*dim5)):list2) dim1 dim2 dim3 dim4 dim5

eliminateRepeated6 list dim1 dim2 dim3 dim4 dim5 dim6 = elmRepeated6 list [] dim1 dim2 dim3 dim4 dim5 dim6
elmRepeated6 [] _ _ _ _ _ _ _= []
elmRepeated6 ((dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony):xs) list2 dim1 dim2 dim3 dim4 dim5 dim6
    | (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)+(fst(dim_garden)*snd(dim_garden)*dim5)+(fst(dim_balcony)*snd(dim_balcony)*dim6))  `elem` list2) = elmRepeated6 xs list2 dim1 dim2 dim3 dim4 dim5 dim6
    | otherwise = (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony) : elmRepeated6 xs (((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)+(fst(dim_garden)*snd(dim_garden)*dim5)+(fst(dim_balcony)*snd(dim_balcony)*dim6)):list2) dim1 dim2 dim3 dim4 dim5 dim6

-- get maximum area possible
coverMax list dim1 dim2 dim3 dim4 dim5 dim6= findMaximumArea list dim1 dim2 dim3 dim4 dim5 dim6
findMaximumArea [] _ _ _ _ _ _= 0
findMaximumArea ((dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony):xs) dim1 dim2 dim3 dim4 dim5 dim6 = maximum [((fst(dim_bedroom)*snd(dim_bedroom)*dim1)+(fst(dim_hall)*snd(dim_hall)*dim2)+(fst(dim_kitchen)*snd(dim_kitchen)*dim3)+(fst(dim_bathroom)*snd(dim_bathroom)*dim4)+(fst(dim_garden)*snd(dim_garden)*dim5)+(fst(dim_balcony)*snd(dim_balcony)*dim6)):: Integer, findMaximumArea(xs) dim1 dim2 dim3 dim4 dim5 dim6]
 
-- catesian products bedroom, hall
cartProd2 xs ys = [(x,y) | x <- xs, y <- ys]
-- catesian products bedroom, hall, kitchen
cartProd3 xs ys = [(dim_bedroom, dim_hall, y) | (dim_bedroom,dim_hall) <- xs, y <- ys]
-- catesian products bedroom, hall, kitchen, bathroom
cartProd4 xs ys = [(dim_bedroom, dim_hall, dim_kitchen, y) | (dim_bedroom,dim_hall,dim_kitchen) <- xs, y <- ys]
-- catesian products bedroom, hall, kitchen, bathroom, garden
cartProd5 xs ys = [(dim_bedroom, dim_hall, dim_kitchen, dim_bathroom, y) | (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom) <- xs, y <- ys]
-- catesian products bedroom, hall, kitchen, bathroom, garden, balcony
cartProd6 xs ys = [(dim_bedroom, dim_hall, dim_kitchen, dim_bathroom, dim_garden, y) | (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden) <- xs, y <- ys]

-- given smallest and largest dimension, get all possible dimensions 
findAllPossibleDim l h = if (fst l == fst h) then findAllPossibleDimSec l h
             else findAllPossibleDimSec l h ++ findAllPossibleDim lnew h where lnew = (fst l + 1, snd l) 

findAllPossibleDimSec l h = if (snd l == snd h) then [l] 
              else l:findAllPossibleDimSec lnew h where lnew = (fst l, snd l + 1)

--Main function
design :: (Integer,Integer,Integer) -> IO ()
design (total_area,bedroom_count,hall_count) = do
 let size_bedroom = findAllPossibleDim (10,10) (15,15)
 let size_hall = findAllPossibleDim (15,10) (20,15)
 let size_kitchen = findAllPossibleDim (7,5) (15,13)
 let size_bathroom = findAllPossibleDim (4,5) (8,9)
 let size_balcony = findAllPossibleDim (5,5) (10,10)
 let size_garden = findAllPossibleDim (10,10) (20,20)
 let area = (total_area :: Integer)
 let count_bedroom = (bedroom_count :: Integer)
 let count_hall = (hall_count :: Integer)
 let count_kitchen = ceiling(fromIntegral count_bedroom/3) :: Integer
 let count_bathroom = count_bedroom + 1
 let count_garden = 1
 let count_balcony = 1

 -- (bedroom, hall)
 let l1 = eliminateRepeated2 (filter (\(dim_bedroom,dim_hall) -> ((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) 
          + (fst(dim_hall)*snd(dim_hall))*count_hall) <= area) (cartProd2 size_bedroom size_hall)) count_bedroom count_hall
 
 -- (bedroom, hall, kitchen)
 let l2 = eliminateRepeated3 (filter (\(dim_bedroom,dim_hall,dim_kitchen) -> (((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) + (fst(dim_hall)*snd(dim_hall)*count_hall) + (fst(dim_kitchen)*snd(dim_kitchen)*count_kitchen))
           <= area)                     
          && (fst(dim_kitchen) <= fst(dim_bedroom) && fst(dim_kitchen) <= fst(dim_hall) && snd(dim_kitchen) <= snd(dim_bedroom) && snd(dim_kitchen) <= snd(dim_hall))) (cartProd3 l1 size_kitchen)) count_bedroom count_hall count_kitchen    
 -- (bedroom, hall, kitchen, bathroom)
 let l3 = eliminateRepeated4 (filter (\(dim_bedroom,dim_hall,dim_kitchen,dim_bathroom) -> (((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) + (fst(dim_hall)*snd(dim_hall)*count_hall) + (fst(dim_kitchen)*snd(dim_kitchen)*count_kitchen) + (fst(dim_bathroom)*snd(dim_bathroom)*count_bathroom))
          <= area)     
           && (fst(dim_bathroom) <= fst(dim_kitchen) && snd(dim_bathroom) <= snd(dim_kitchen))) (cartProd4 l2 size_bathroom)) count_bedroom count_hall count_kitchen count_bathroom  

 -- (bedroom, hall, kitchen, bathroom, garden)
 let l4 = eliminateRepeated5 (filter (\(dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden) -> (((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) + (fst(dim_hall)*snd(dim_hall)*count_hall) + (fst(dim_kitchen)*snd(dim_kitchen)*count_kitchen) 
          + (fst(dim_bathroom)*snd(dim_bathroom)*count_bathroom) + (fst(dim_garden)*snd(dim_garden)*count_garden))        
           <= area))    
          (cartProd5 l3 size_garden)) count_bedroom count_hall count_kitchen count_bathroom count_garden    

 -- (bedroom, hall, kitchen, bathroom, garden, balcony)
 let l5 = eliminateRepeated6 (filter (\(dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony) -> (((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) + (fst(dim_hall)*snd(dim_hall)*count_hall) + (fst(dim_kitchen)*snd(dim_kitchen)*count_kitchen)     
          + (fst(dim_bathroom)*snd(dim_bathroom)*count_bathroom) + (fst(dim_garden)*snd(dim_garden)*count_garden) + (fst(dim_balcony)*snd(dim_balcony)*count_balcony))          
           <= area))    
          (cartProd6 l4 size_balcony)) count_bedroom count_hall count_kitchen count_bathroom count_garden count_balcony 
 

 -- calculate max area possible
 let maxArea = coverMax l5 count_bedroom count_hall count_kitchen count_bathroom count_garden count_balcony
 -- get the dimensions with maximum area
 let result = filter (\(dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony) -> ((fst(dim_bedroom)*snd(dim_bedroom)*count_bedroom) + (fst(dim_hall)*snd(dim_hall)*count_hall) + (fst(dim_kitchen)*snd(dim_kitchen)*count_kitchen) 
              + (fst(dim_bathroom)*snd(dim_bathroom)*count_bathroom) + (fst(dim_garden)*snd(dim_garden)*count_garden) + (fst(dim_balcony)*snd(dim_balcony)*count_balcony)       
              == maxArea)) l5

 -- Displaying Results
 if (length result == 0)
  then putStrLn $ "Not possible to plan with specified inputs"
   else do 
    let (dim_bedroom,dim_hall,dim_kitchen,dim_bathroom,dim_garden,dim_balcony) = result !! 0
    putStrLn("Bedroom: " ++ show(count_bedroom) ++ " " ++ "(" ++ show(fst(dim_bedroom)) ++ "X" ++ show(snd(dim_bedroom)) ++ ")") 
    putStrLn("Hall: " ++ show(count_hall) ++ " " ++ "(" ++ show(fst(dim_hall)) ++ "X" ++ show(snd(dim_hall)) ++ ")")
    putStrLn("Kitchen: " ++ show(count_kitchen) ++ " " ++ "(" ++ show(fst(dim_kitchen)) ++ "X" ++ show(snd(dim_kitchen)) ++ ")")
    putStrLn("Bathroom: " ++ show(count_bathroom) ++ " " ++ "(" ++ show(fst(dim_bathroom)) ++ "X" ++ show(snd(dim_bathroom)) ++ ")")
    putStrLn("Garden: " ++ show(count_garden) ++ " " ++ "(" ++ show(fst(dim_garden)) ++ "X" ++ show(snd(dim_garden)) ++ ")")
    putStrLn("Balcony: " ++ show(count_balcony) ++ " " ++ "(" ++ show(fst(dim_balcony)) ++ "X" ++ show(snd(dim_balcony)) ++ ")")
    putStrLn("Unused Space: " ++ show(area-maxArea))