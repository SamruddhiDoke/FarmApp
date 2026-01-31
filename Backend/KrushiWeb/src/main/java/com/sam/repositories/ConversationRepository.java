package com.sam.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sam.models.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByListingTypeAndListingIdAndBuyer_IdAndOwner_Id(
            String listingType, Long listingId, Long buyerId, Long ownerId);
}
