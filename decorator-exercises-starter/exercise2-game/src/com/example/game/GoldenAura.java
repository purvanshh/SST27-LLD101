package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void move() {
        System.out.println("[GoldenAura] Shimmering while moving with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[GoldenAura] Striking with golden power using sprite " + getSprite());
    }

    @Override
    public int getSpeed() { return wrapped.getSpeed() + 1; }

    @Override
    public int getDamage() { return wrapped.getDamage() + 2; }

    @Override
    public String getSprite() { return "golden_" + wrapped.getSprite(); }
}
