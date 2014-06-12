; 33. Replicate a sequence
(fn [s c]
  (mapcat #(repeat c %) s))

