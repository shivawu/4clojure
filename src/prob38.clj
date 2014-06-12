; 38. Maximum value
(fn [x & more]
  (reduce #(if (> %1 %2) %1 %2) x more))

