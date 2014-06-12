; 60. Sequence Reductions
(fn reds
  ([f coll]
    (lazy-seq
      (if (empty? coll)
        []
        (reds f (first coll) (rest coll)))))
  ([f init coll]
    (cons init
      (lazy-seq
        (if (empty? coll)
          []
          (reds f (f init (first coll)) (rest coll)))))))

