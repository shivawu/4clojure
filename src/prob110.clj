; 110. Sequence of pronunciations
(comp rest
  (partial iterate
    (fn [s]
      (mapcat (juxt count first) (partition-by identity s)))))

