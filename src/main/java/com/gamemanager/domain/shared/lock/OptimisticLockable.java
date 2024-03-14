package com.gamemanager.domain.shared.lock;

public interface OptimisticLockable {
    Version getVersion();
}
