package com.example.realidadaumentada

import android.content.Context
import android.graphics.Color
import android.view.MotionEvent
import org.rajawali3d.animation.Animation
import org.rajawali3d.animation.EllipticalOrbitAnimation3D
import org.rajawali3d.animation.RotateOnAxisAnimation
import org.rajawali3d.loader.LoaderOBJ
import org.rajawali3d.loader.ParsingException
import org.rajawali3d.materials.Material
import org.rajawali3d.materials.methods.DiffuseMethod.Lambert
import org.rajawali3d.materials.textures.Texture
import org.rajawali3d.math.vector.Vector3
import org.rajawali3d.renderer.Renderer


class BasicRenderer(context: Context?) : Renderer(context) {


    init {
        setFrameRate(60)
    }

    override fun onOffsetsChanged(p0: Float, p1: Float, p2: Float, p3: Float, p4: Int, p5: Int) {
    }

    override fun onTouchEvent(p0: MotionEvent?) {
    }

    public override fun onRender(elapsedTime: Long, deltaTime: Double) {
        super.onRender(elapsedTime, deltaTime)
    }

    override fun initScene() {
        try {
            /** Posicion de camara **/
            currentScene.backgroundColor = Color.WHITE
            currentCamera.enableLookAt()

            /** Textura **/
            val material = Material()
            material.enableLighting(true)
            material.diffuseMethod = Lambert()
            material.colorInfluence = 0f
            material.addTexture(Texture("black_panther", R.drawable.download))

            val parser = LoaderOBJ(
                mContext.resources,
                mTextureManager, R.raw.black_panther
            )
            parser.parse()
            val arrow = parser.parsedObject
            arrow.material = material
            val scaleFactor = 1.0 / arrow.boundingBox.max.y
            arrow.setScale(scaleFactor)
            arrow.setPosition(0.0, 0.0, 0.0)
            currentScene.addChild(arrow)

            val rotationAnim = RotateOnAxisAnimation(Vector3.Axis.Y, 360.0)
            rotationAnim.durationMilliseconds = 10000
            rotationAnim.repeatMode = Animation.RepeatMode.INFINITE
            rotationAnim.transformable3D = arrow
            currentScene.registerAnimation(rotationAnim)
            rotationAnim.play()

        } catch (e: ParsingException) {
            e.printStackTrace()
        }
    }

}