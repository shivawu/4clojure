; 147. Pascal's Trapezoid
#(iterate
   (fn [x]
     (map + (cons 0N x) (concat x [0N])))
   %)

