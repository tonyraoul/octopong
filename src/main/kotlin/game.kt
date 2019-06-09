package octopong
import info.laht.threekt.cameras.PerspectiveCamera
import info.laht.threekt.lights.AmbientLight
import info.laht.threekt.math.ColorConstants
import info.laht.threekt.math.Euler
import info.laht.threekt.renderers.WebGLRenderer
import info.laht.threekt.renderers.WebGLRendererParams
import octopong.engine.Scene
import octopong.engine.primitives.Box
import kotlin.browser.document
import kotlin.browser.window

class Game {

    private val renderer: WebGLRenderer
    private val scene: Scene = Scene()
    private val camera: PerspectiveCamera
    private val cube: Box = Box(1, 1, 1)

    init {
        scene.add(AmbientLight())

        camera = PerspectiveCamera(75, window.innerWidth.toDouble() / window.innerHeight, 0.1, 1000)
        camera.position.setZ(5)

        renderer = WebGLRenderer(
            WebGLRendererParams(
            antialias = true
        )
        ).apply {
            setClearColor(ColorConstants.skyblue, 1)
            setSize(window.innerWidth, window.innerHeight)
        }

        document.getElementById("container")?.apply {
            appendChild(renderer.domElement)
        }



        // Create the final object to add to the scene
        scene.add(cube)
        window.addEventListener("resize", {
            camera.aspect = window.innerWidth.toDouble() / window.innerHeight;
            camera.updateProjectionMatrix();
            renderer.setSize( window.innerWidth, window.innerHeight )
        }, false)

    }

    fun animate() {
        window.requestAnimationFrame {
            cube.rotation = Euler(cube.rotation.x + 0.05)
            animate()
        }
        renderer.render(scene.threeScene, camera)
    }

}