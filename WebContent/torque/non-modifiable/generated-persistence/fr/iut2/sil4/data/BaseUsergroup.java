package fr.iut2.sil4.data;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.BooleanKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.om.ColumnAccessByName;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.util.Transaction;
import org.apache.commons.lang.ObjectUtils;


/**
 * Group Table
 *
 * This class was autogenerated by Torque on:
 *
 * [Sun Feb 23 17:07:40 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to Usergroup
 */
public abstract class BaseUsergroup 
    implements Persistent, Serializable, ColumnAccessByName
{
    /** Serial version */
    private static final long serialVersionUID = 1393171660541L;



    /** Group Id */
    private int groupId = 0;

    /** Group Name */
    private String groupName = null;

    /** Whether this object was modified after loading or after last save. */
    private boolean modified = true;

    /** 
     * Whether this object was loaded from the database or already saved 
     * (false) or whether it is not yet in the database(true).
     */
    private boolean isNew = true;

    /** Flag which indicates whether this object is currently saving. */
    private boolean saving = false;

    /** 
     * Flag which indicates whether this object is currently loaded
     * from the database. 
     */
    private boolean loading = false;

    /** 
     * Flag which indicates whether this object was deleted from the database.
     * Note that this flags does not always display the current database state,
     * there is no magical connection between this flag and the database.
     */
    private boolean deleted = false;



    /** Defines the collStudents field. */
    protected List<Student> collStudents = null;



    /**
     * Get the value of groupId.
     * The field is described as follows: 
     * Group Id
     *
     * @return int
     */
    public int getGroupId() 
    {
        
        return groupId;
    }

    /**
     * Set the value of groupId.
     * The field is described as follows: 
     * Group Id
     *
     * @param v new value
     */
    public void setGroupId(int v)
    {
        if (this.groupId != v)
        {
            setModified(true);
        }

        this.groupId = v;

        // update associated objects in collStudents 
        if (collStudents != null)
        {
            for (int i = 0; i < collStudents.size(); i++)
            {
                ((Student) collStudents.get(i))
                        .setGroupId(v);
            }
        }

    }
    
    /**
     * Get the value of groupName.
     * The field is described as follows: 
     * Group Name
     *
     * @return String
     */
    public String getGroupName() 
    {
        
        return groupName;
    }

    /**
     * Set the value of groupName.
     * The field is described as follows: 
     * Group Name
     *
     * @param v new value
     */
    public void setGroupName(String v)
    {
        if (!ObjectUtils.equals(this.groupName, v))
        {
            setModified(true);
        }

        this.groupName = v;


    }
    

    /**
     * Returns whether the object has ever been saved.  This will
     * be false, if the object was retrieved from storage or was created
     * and then saved.
     *
     * @return true, if the object has never been persisted.
     */
    public boolean isNew()
    {
        return isNew;
    }

    /**
     * Sets whether the object has ever been saved.
     *
     * @param isNew true if the object has never been saved, false otherwise.
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    /**
     * Returns whether the object has been modified.
     *
     * @return True if the object has been modified.
     */
    public boolean isModified()
    {
        return modified;
    }

    /**
     * Sets whether the object has been modified.
     *
     * @param modified true if the object has been modified, false otherwise.
     */
    public void setModified(boolean modified)
    {
        this.modified = modified;
    }

    /**
     * Sets the modified state for the object to be false.
     */
    public void resetModified()
    {
        modified = false;
    }


    /**
     * Returns whether this object is currently saving.
     *
     * @return true if this object is currently saving, false otherwise.
     */
    public boolean isSaving()
    {
        return saving;
    }

    /**
     * Sets whether this object is currently saving.
     *
     * @param saving true if this object is currently saving, false otherwise.
     */
    public void setSaving(boolean saving)
    {
        this.saving = saving;
    }


    /**
     * Returns whether this object is currently being loaded from the database.
     *
     * @return true if this object is currently loading, false otherwise.
     */
    public boolean isLoading()
    {
        return loading;
    }

    /**
     * Sets whether this object is currently being loaded from the database.
     *
     * @param loading true if this object is currently loading, false otherwise.
     */
    public void setLoading(boolean loading)
    {
        this.loading = loading;
    }


    /**
     * Returns whether this object was deleted from the database.
     * Note that this getter does not automatically reflect database state,
     * it will be set to true by Torque if doDelete() was called with this 
     * object. Bulk deletes and deletes via primary key do not change
     * this flag. Also, if doDelete() was called on an object which does
     * not exist in the database, the deleted flag is set to true even if
     * it was not deleted.
     *
     * @return true if this object was deleted, false otherwise.
     */
    public boolean isDeleted()
    {
        return deleted;
    }

    /**
     * Sets whether this object was deleted from the database.
     *
     * @param deleted true if this object was deleted, false otherwise.
     */
    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }




    /**
     * Initializes the cache collStudents for referenced objects.
     * This, means, if collStudents is null when this operation is called, it is
     * initialized with an empty collection, otherwise it remains unchanged. 
     *
     * @return the (possibly new) content of the field collStudents, not null.
     */
    public List<Student> initStudents()
    {
        if (collStudents == null)
        {
            collStudents = new ArrayList<Student>();
        }
        return collStudents;
    }

    /**
     * Checks whether the cache collStudents for referenced objects has either been
     * loaded from the database or has been manually initialized.
     */
    public boolean isStudentsInitialized()
    {
        return (collStudents != null);
    }


    /**
     * Method called to associate a Student object to this object
     * through the collStudents foreign key attribute.
     * If the associated objects were not retrieved before
     * and this object is not new, the associated objects are retrieved
     * from the database before adding the <code>toAdd</code> object.
     *
     * @param toAdd the object to add to the associated objects, not null.
     *
     * @throws TorqueException if retrieval of the associated objects fails.
     * @throws NullPointerException if toAdd is null.
     */
    public void addStudent(Student toAdd)
        throws TorqueException
    {
        toAdd.setUsergroup((Usergroup) this);
        getStudents().add(toAdd);
    }

    /**
     * Method called to associate a Student object to this object
     * through the collStudents foreign key attribute using connection.
     *
     * @param l Student
     * @throws TorqueException
     */
    public void addStudent(Student l, Connection con) throws TorqueException
    {
        getStudents(con).add(l);
        l.setUsergroup((Usergroup) this);
    }
    
    /**
     * The criteria used to select the current contents of collStudents
     */
    private Criteria lastStudentCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getStudents(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List<Student> getStudents()
        throws TorqueException
    {
        if (collStudents == null)
        {
            collStudents = getStudents(new Criteria());
        }
        return collStudents;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this BaseUsergroup has previously
     * been saved, it will retrieve related collStudents from storage.
     * If this BaseUsergroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List<Student> getStudents(Criteria criteria) throws TorqueException
    {
        if (collStudents == null)
        {
            if (isNew())
            {
               initStudents();
            }
            else
            {
                criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId() );
                collStudents = fr.iut2.sil4.data.StudentPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId() );
                if (lastStudentCriteria == null 
                        || !lastStudentCriteria.equals(criteria))
                {
                    collStudents = fr.iut2.sil4.data.StudentPeer.doSelect(criteria);
                }
            }
        }
        lastStudentCriteria = criteria;

        return collStudents;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getStudents(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<Student> getStudents(Connection con) throws TorqueException
    {
        if (collStudents == null)
        {
            collStudents = getStudents(new Criteria(), con);
        }
        return collStudents;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this BaseUsergroup has previously
     * been saved, it will retrieve the related Student Objects 
     * from storage.
     * If this BaseUsergroup is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List<Student> getStudents(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collStudents == null)
        {
            if (isNew())
            {
               initStudents();
            }
            else
            {
                criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId());
                collStudents = fr.iut2.sil4.data.StudentPeer.doSelect(criteria, con);
            }
        }
        else
        {
             // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId());
                if (!lastStudentCriteria.equals(criteria))
                {
                    collStudents = fr.iut2.sil4.data.StudentPeer.doSelect(criteria, con);
                }
            }
        }
        lastStudentCriteria = criteria;

        return collStudents;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this BaseUsergroup is new, it will return
     * an empty collection; or if this thisObjectClassName has previously
     * been saved, it will retrieve the related objects from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can change the access modifier to public
     * by overriding this method in the child class.
     */
    protected List<Student> getStudentsJoinUsergroup(Criteria criteria) throws TorqueException
    {
        return getStudentsJoinUsergroup(criteria, null);
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this BaseUsergroup is new, it will return
     * an empty collection; or if this BaseUsergroup has previously
     * been saved, it will retrieve the related objects from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can change the access modifier to public
     * by overriding this method in the child class.
     */
    protected List<Student> getStudentsJoinUsergroup(Criteria criteria, Connection connection)
        throws TorqueException
    {
        if (collStudents == null)
        {
            if (isNew())
            {
                initStudents();
            }
            else
            {
                criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId() );
                collStudents = fr.iut2.sil4.data.StudentPeer.doSelectJoinUsergroup(criteria, connection);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.and(fr.iut2.sil4.data.StudentPeer.GROUP_ID, getGroupId() );
            if (!lastStudentCriteria.equals(criteria))
            {
                collStudents = fr.iut2.sil4.data.StudentPeer.doSelectJoinUsergroup(criteria, connection);
            }
        }
        lastStudentCriteria = criteria;

        return collStudents;
    }




    private static final List<String> FIELD_NAMES;

    static
    {
        List<String> fieldNames
                = new ArrayList<String>();
        fieldNames.add("GroupId");
        fieldNames.add("GroupName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static List<String> getFieldNames()
    {
        return FIELD_NAMES;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("GroupId"))
        {
            return new Integer(getGroupId());
        }
        if (name.equals("GroupName"))
        {
            return getGroupName();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("GroupId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setGroupId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("GroupName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setGroupName((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(fr.iut2.sil4.data.UsergroupPeer.GROUP_ID))
        {
            return new Integer(getGroupId());
        }
        if (name.equals(fr.iut2.sil4.data.UsergroupPeer.GROUP_NAME))
        {
            return getGroupName();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (fr.iut2.sil4.data.UsergroupPeer.GROUP_ID.getSqlExpression().equals(name))
        {
            return setByName("GroupId", value);
        }
        if (fr.iut2.sil4.data.UsergroupPeer.GROUP_NAME.getSqlExpression().equals(name))
        {
            return setByName("GroupName", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getGroupId());
        }
        if (pos == 1)
        {
            return getGroupName();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (position == 0)
        {
            return setByName("GroupId", value);
        }
        if (position == 1)
        {
            return setByName("GroupName", value);
        }
        return false;
    }



    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save() throws TorqueException
    {
        save(UsergroupPeer.DATABASE_NAME);
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     * @param dbName the name of the database to which the object
     *        should be saved.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(String dbName) 
            throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally.
     *
     * @param toSave the object to be saved, not null.
     * @param con the connection to use for saving the object, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(Connection con) 
            throws TorqueException
    {
        if (isSaving())
        {
            return;
        }
        try
        {
            setSaving(true);
            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    UsergroupPeer.doInsert((Usergroup) this, con);
                    setNew(false);
                }
                else
                {
                    UsergroupPeer.doUpdate((Usergroup) this, con);
                }
            }

            if (isStudentsInitialized())
            {
                for (Student collStudents : getStudents())
                {
                    collStudents.save(con);
                }
            }
        }
        finally
        {
            setSaving(false);
        }
    }




    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key groupId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setGroupId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setGroupId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getGroupId());
    }



    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Usergroup copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using a connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Usergroup copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Usergroup copy(boolean deepcopy) throws TorqueException
    {
        Usergroup usergroup = new Usergroup();

        return copyInto(usergroup, deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Usergroup copy(boolean deepcopy, Connection con) throws TorqueException
    {
        Usergroup usergroup = new Usergroup();

        return copyInto(usergroup, deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    public Usergroup copyInto(Usergroup copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    public Usergroup copyInto(Usergroup copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Usergroup copyInto(Usergroup copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setGroupId(0);
        copyObj.setGroupName(groupName);

        if (deepcopy)
        {
            if (collStudents != null)
            {
                for (int i = 0; i < collStudents.size(); i++)
                {
                    Student obj = collStudents.get(i);
                    copyObj.addStudent(obj.copy());
                }
            }
            else
            {
                copyObj.collStudents = null;
            }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    public Usergroup copyInto(Usergroup copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setGroupId(0);
        copyObj.setGroupName(groupName);

        if (deepcopy)
        {
            for (Student obj : getStudents(con))
            {
                copyObj.addStudent(obj.copy());
            }
        }
        return copyObj;
    }

    /** The Peer class */
    private static final fr.iut2.sil4.data.UsergroupPeer peer
            = new fr.iut2.sil4.data.UsergroupPeer();

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public fr.iut2.sil4.data.UsergroupPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return fr.iut2.sil4.data.UsergroupPeer.getTableMap();
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Usergroup:\n");
        str.append("groupId = ")
           .append(getGroupId())
           .append("\n");
        str.append("groupName = ")
           .append(getGroupName())
           .append("\n");
        return(str.toString());
    }

    /**
     * Compares the primary key of this instance with the key of another.
     *
     * @param toCompare The object to compare to.
     * @return Whether the primary keys are equal and the object have the
     *         same class.
     */
    public boolean equals(Object toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (!getClass().equals(toCompare.getClass()))
        {
            return false;
        }
        Usergroup other = (Usergroup) toCompare;
        if (getPrimaryKey() == null || other.getPrimaryKey() == null)
        {
            return false;
        }
        return getPrimaryKey().equals(other.getPrimaryKey());
    }

    /**
     * If the primary key is not <code>null</code>, return the hashcode of the
     * primary key.  Otherwise calls <code>Object.hashCode()</code>.
     *
     * @return an <code>int</code> value
     */
    public int hashCode()
    {
        ObjectKey ok = getPrimaryKey();
        if (ok == null)
        {
            return super.hashCode();
        }

        return ok.hashCode();
    }



    /**
     * Compares the content of this object to another object
     *
     * @param toCompare The object to compare to.
     * @return true if all of the columns in the other object have 
     *         the same value as the objects in this class.
     */
    public boolean valueEquals(Usergroup toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (this.groupId != toCompare.getGroupId())
        {
            return false;
        }
        if (!ObjectUtils.equals(this.groupName, toCompare.getGroupName()))
        {
            return false;
        }
        return true;
    }



}
