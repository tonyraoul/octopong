package octopong.engine.primitives

import info.laht.threekt.core.Object3D
import info.laht.threekt.geometries.BoxBufferGeometry
import info.laht.threekt.materials.MeshPhongMaterial
import info.laht.threekt.math.ColorConstants
import info.laht.threekt.objects.Mesh
import octopong.engine.GameObject

class Box(width: Number, height: Number, depth: Number): GameObject() {
    init {
        renderObject = Object3D()
        Mesh(
            BoxBufferGeometry(width, height, depth),
            MeshPhongMaterial().apply {
                this.color.set(ColorConstants.aliceblue)
            }).also ( renderObject!!::add )
    }
}