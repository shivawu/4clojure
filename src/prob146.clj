; 146. Trees into tables
(fn [mm]
  (into {}
    (for [[k mv] mm
          [k2 v] mv]
      [[k k2] v])))

