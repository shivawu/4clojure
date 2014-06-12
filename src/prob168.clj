; 168. Infinite Matrix
(fn infmat
  ([f n m] (letfn [(row [j] (lazy-seq (cons (f n j) (row (inc j)))))]
             (lazy-seq (cons (row m) (infmat f (inc n) m)))))
  ([f] (infmat f 0 0))
  ([f n m s t] (take s (map #(take t %) (infmat f n m)))))

