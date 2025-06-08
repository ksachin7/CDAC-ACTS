import React, { useState, useEffect } from 'react';

const LOCAL_STORAGE_KEY = 'portfolio_profiles';

function App() {
  const [profiles, setProfiles] = useState([]);
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    phone: '',
    skills: '',
    bio: ''
  });
  const [errors, setErrors] = useState({});
  const [editIndex, setEditIndex] = useState(null);

  useEffect(() => {
    const stored = localStorage.getItem(LOCAL_STORAGE_KEY);
    if (stored) setProfiles(JSON.parse(stored));
  }, []);

  useEffect(() => {
    localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(profiles));
  }, [profiles]);

  const validate = () => {
    const errs = {};
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (formData.name.trim().length < 3)
      errs.name = 'Name must be at least 3 characters.';

    if (!emailRegex.test(formData.email))
      errs.email = 'Enter a valid email.';

    if (!/^\d{10}$/.test(formData.phone))
      errs.phone = 'Phone must be exactly 10 digits.';

    if (!formData.skills.trim())
      errs.skills = 'Skills are required.';

    if (formData.bio.trim().split(/\s+/).length < 10)
      errs.bio = 'Bio must have at least 10 words.';

    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    if (!validate()) return;

    if (editIndex !== null) {
      const updated = [...profiles];
      updated[editIndex] = formData;
      setProfiles(updated);
      setEditIndex(null);
    } else {
      setProfiles([...profiles, formData]);
    }

    setFormData({ name: '', email: '', phone: '', skills: '', bio: '' });
    setErrors({});
  };

  const handleEdit = index => {
    setFormData(profiles[index]);
    setEditIndex(index);
    setErrors({});
  };

  const handleDelete = index => {
    const updated = profiles.filter((_, i) => i !== index);
    setProfiles(updated);
    if (editIndex === index) setFormData({ name: '', email: '', phone: '', skills: '', bio: '' });
    setEditIndex(null);
  };

  return (
    <div className="container mt-5">
      <h2 className="mb-4">Portfolio Manager (with Validation)</h2>

      <form onSubmit={handleSubmit} noValidate>
        <div className="row g-3 mb-3">
          {['name', 'email', 'phone', 'skills'].map(field => (
            <div className="col-md-3" key={field}>
              <input
                type="text"
                className={`form-control ${errors[field] ? 'is-invalid' : ''}`}
                placeholder={field[0].toUpperCase() + field.slice(1)}
                name={field}
                value={formData[field]}
                onChange={handleChange}
              />
              {errors[field] && <div className="invalid-feedback">{errors[field]}</div>}
            </div>
          ))}
        </div>
        <div className="mb-3">
          <textarea
            className={`form-control ${errors.bio ? 'is-invalid' : ''}`}
            placeholder="Bio (min. 10 words)"
            name="bio"
            rows="3"
            value={formData.bio}
            onChange={handleChange}
          />
          {errors.bio && <div className="invalid-feedback">{errors.bio}</div>}
        </div>
        <button type="submit" className="btn btn-primary">
          {editIndex !== null ? 'Update Profile' : 'Add Profile'}
        </button>
      </form>

      <hr className="my-4" />

      <h4>Saved Profiles</h4>
      <table className="table table-bordered table-striped mt-3">
        <thead>
          <tr>
            <th>Name</th><th>Email</th><th>Phone</th><th>Skills</th><th>Bio</th><th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {profiles.length === 0 ? (
            <tr><td colSpan="6" className="text-center">No profiles added yet.</td></tr>
          ) : (
            profiles.map((profile, index) => (
              <tr key={index}>
                <td>{profile.name}</td>
                <td>{profile.email}</td>
                <td>{profile.phone}</td>
                <td>{profile.skills}</td>
                <td>{profile.bio}</td>
                <td>
                  <button className="btn btn-sm btn-warning me-2" onClick={() => handleEdit(index)}>Edit</button>
                  <button className="btn btn-sm btn-danger" onClick={() => handleDelete(index)}>Delete</button>
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default App;
