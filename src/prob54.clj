; 54. Partition a Sequence
(fn [n s]
  (reverse
    (let [groups (reduce
                   (fn [x y]
                     (if (< (count (first x)) n)
                       (cons (conj (first x) y) (rest x))
                       (cons [y] x)))
                   (list [])
                   s)]
      (if (< (count (first groups)) n) (rest groups) groups))))

