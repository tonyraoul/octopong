package octopong.engine

import info.laht.threekt.core.Object3D
import info.laht.threekt.math.Euler
import info.laht.threekt.math.Vector3

open class GameObject {
    var children:MutableList<GameObject> = mutableListOf()
    var renderObject: Object3D? = null
    fun add(object3D: Object3D){
      var gameObject = GameObject()
      gameObject.renderObject = object3D
      add(gameObject)
    }
    fun add(gameObject:GameObject) {
        renderObject?.add(gameObject.renderObject ?: throw Exception("Cannot add null object"))
        children.add(gameObject)
    }
    var position = Vector3()
      set(value) {
          renderObject?.position?.x = value.x
          renderObject?.position?.y = value.y
          renderObject?.position?.z = value.z
          field = value
      }
    var rotation = Euler()
        set(value) {
            renderObject?.setRotationFromEuler(value)
            field = value
        }
}