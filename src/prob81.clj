; 81. Set Intersection
(fn [s1 s2]
  (into #{} (for [x s1 :when (contains? s2 x)] x)))

