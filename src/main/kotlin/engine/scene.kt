package octopong.engine

import info.laht.threekt.scenes.Scene as ThreeScene

class Scene : GameObject(){
    init {
        renderObject = ThreeScene()
    }
    val threeScene get() = renderObject as info.laht.threekt.scenes.Scene
}