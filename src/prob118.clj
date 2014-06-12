; 118. Re-implement Map
(fn _ [f s]
  (lazy-seq
    (when-let [s (seq s)]
      (cons (f (first s)) (_ f (rest s))))))

