package com.grupp28gdx.game;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.grupp28gdx.game.states.PlayState;

public class BodyContactListener implements ContactListener {

    private PlayState parent;

    public BodyContactListener(PlayState parent){
        this.parent = parent;
    }

    @Override
    public void beginContact(Contact contact) {
        System.out.println("Contact");
        Fixture objectA = contact.getFixtureA();
        Fixture objectB = contact.getFixtureB();
        System.out.println(objectA.getBody().getType()+" has hit "+ objectB.getBody().getType());
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

}