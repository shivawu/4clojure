; 153. Pairwise Disjoint Sets
(fn [ss]
  (not (some true?
         (for [s ss t ss
               :when (not (identical? s t))
               x s y t]
           (= x y)))))

