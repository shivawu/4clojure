; 46. Flipping out
(fn [f]
  (fn [& args]
    (apply f (reverse args))))

