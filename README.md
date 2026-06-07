# EmptyWorld

<img width="1397" height="906" alt="grafik" src="https://github.com/user-attachments/assets/7b2f161b-269f-4457-9aca-59179c974337" />

EmptyWorld is a "empty world" / void generator for PowerNukkitX.
Download the jar from the releases and drop it into your server.

You can generate an empty world using worldmanager or modifying your worlds config.

```json
{
  "format": "leveldb",
  "enable": true,
  "generators": {
    "0": {
      "name": "emptyworld",
      "seed": 5310239330429337398,
      "enableAntiXray": false,
      "antiXrayMode": "LOW",
      "preDeobfuscate": true,
      "dimensionData": {
        "dimensionName": "minecraft:overworld",
        "dimensionId": 0,
        "minHeight": -64,
        "maxHeight": 319,
        "height": 384,
        "chunkSectionCount": 24
      },
      "preset": {
        "block": true,
        "biome": "minecraft:jungle"
      }
    }
  }
}
```
