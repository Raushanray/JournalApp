package com.rcwd.journalApp.repository;

import com.rcwd.journalApp.entity.ConfigJournalAppEntity;
import com.rcwd.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
