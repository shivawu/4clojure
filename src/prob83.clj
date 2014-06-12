; 83. A Half-Truth
(fn [& x]
  (boolean (and (not (every? true? x)) (some true? x))))

