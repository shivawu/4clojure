; 107. Simple closures
(fn [n]
  (fn [x]
    (apply * (repeat n x))))

