package utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import static utils.constants.PPM;

public class TiledObjectUtilEnemy {

    public static void parseTiledObjectLayer(World world, MapObjects objects) {
        for (MapObject object : objects) {
            Shape shape;

            if (object instanceof PolylineMapObject) {
                shape = createPolyline((PolylineMapObject) object);
            } else {
                continue;
            }

//              Body pBody;
//        BodyDef def = new BodyDef();
//        FixtureDef fdef = new FixtureDef();
//        PolygonShape shape = new PolygonShape();
//            fdef.shape = shape;



            Body body;
            BodyDef bdef = new BodyDef();
            FixtureDef fdef = new FixtureDef();
            bdef.type = BodyDef.BodyType.StaticBody;
            body = world.createBody(bdef);
            fdef.shape = shape;
            fdef.filter.categoryBits = utils.constants.Bit_EnemyWalls;
            fdef.filter.maskBits = utils.constants.Bit_Enemy;
//            body.createFixture(shape, 1.0f);
            body.createFixture(fdef);


        }
    }
//creates the polyline object from the tiled map

    private static ChainShape createPolyline(PolylineMapObject polyline) {
        float[] vertices = polyline.getPolyline().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < worldVertices.length; i++) {
            worldVertices[i] = new Vector2(vertices[i * 2] / constants.PPM, vertices[i * 2 + 1] / constants.PPM);
        }
        ChainShape cs = new ChainShape();
        cs.createChain(worldVertices);
        return cs;
    }
}
