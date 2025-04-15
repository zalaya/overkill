# 🧪 Testing Style Guide ✍️

Estos tests están escritos buscando claridad, intención y buen gusto.

- Los builders están extraídos en fixtures (`aTaskWith`, `aTaskEntityWith`, etc.).
- No hay métodos privados si solo encapsulan una línea.
- Solo se agrupan assertions cuando forman una unidad semántica (como `assertPersistenceOf`).
- Los nombres de test siguen `given_when_then`.
- Las assertions encadenadas se separan en líneas solo si hay más de una llamada.
- Los tests deben leerse como frases completas, no como puzzles.

## TL;DR

🔒 Está limpio. Está claro. No lo toques si no lo estás mejorando de verdad.
