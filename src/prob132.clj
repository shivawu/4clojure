; 132. Insert between two items
(fn _ [f v [x y :as coll]]
  (lazy-seq
    (if (and x y)
      (if (f x y)
        (list* x v (_ f v (rest coll)))
        (list* x (_ f v (rest coll))))
      coll)))

