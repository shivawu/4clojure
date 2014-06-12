; 166. Comparisons
(fn [op x y]
  (cond
    (op x y) :lt (op y x) :gt :else :eq))

