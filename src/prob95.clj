; 95. To Tree, or not to Tree
(fn _ [s]
  (or
    (nil? s)
    (and
      (sequential? s)
      (= 3 (count s))
      (not (sequential? (nth s 0)))
      (_ (nth s 1))
      (_ (nth s 2)))))

