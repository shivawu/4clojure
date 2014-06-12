; 99. Product Digits
(fn [a b]
  (map #(-> % int (- 48)) (seq (str (* a b)))))

