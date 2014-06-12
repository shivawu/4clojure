; 34. Implement range
(fn [st ed]
  (loop [i st res []]
    (if (>= i ed)
      res
      (recur (+ 1 i) (conj res i)))))

