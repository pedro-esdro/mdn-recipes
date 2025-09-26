package mdn.mdn_recipes.shared.util;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.UUID;

public final class UUIDv7 {

    private UUIDv7() {}

    public static UUID create() {
        return UuidCreator.getTimeOrderedEpoch();
    }

}
