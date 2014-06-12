; 85. Power Set
(fn ps [s]
  (if-let [es (seq s)]
    (let [r (ps (rest es))]
      (into r (map #(conj % (first es)) r)))
      #{#{}}))

