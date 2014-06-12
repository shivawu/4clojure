; 22. Count a Sequence
(fn [sq]
  (loop [x sq res 0]
    (if (empty? x)
      res
      (recur (rest x) (+ 1 res)))))

