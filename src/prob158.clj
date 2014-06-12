; 158. Decurry
(fn [f]
  (fn [& args]
    (reduce #(%1 %2) f args)))

