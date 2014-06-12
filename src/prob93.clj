; 93. Partially Flatten a Sequence
(fn pflat [coll]
  (letfn [(level1? [x]
            (every? #(not (sequential? %)) x))]
    (prn coll)
    (if (level1? coll)
      [coll]
      (mapcat pflat coll))))

