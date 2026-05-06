package com.cinema.repositories;

import java.util.List;
import com.cinema.models.Avatar;

public interface AvatarRepository extends CrudeRepository<Avatar> {
    public List<Avatar> findByUserId(String userId);
}
