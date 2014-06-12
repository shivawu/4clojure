; 113. Making Data Dance
(fn [& coll]
  (reify
    java.lang.Object
    (toString [_]
      (apply str (interpose ", " (sort coll))))
    clojure.lang.Seqable
    (seq [_]
      (seq (distinct coll)))))

