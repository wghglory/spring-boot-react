import React, {useState} from 'react';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import IconButton from '@mui/material/IconButton';
import EditIcon from '@mui/icons-material/Edit';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';

import {CarPayload} from '../models/Car';
import Button from '@mui/material/Button';

export default function CarEdit({data, updateCar}: {data: any; updateCar: (car: CarPayload, link: string) => void}) {
  const [open, setOpen] = useState(false);
  const [car, setCar] = useState<CarPayload>({
    brand: '',
    model: '',
    color: '',
    year: '',
    price: '',
  });

  // Open the modal form and update the car state
  const handleClickOpen = () => {
    setCar({
      brand: data.row.brand,
      model: data.row.model,
      color: data.row.color,
      year: data.row.year,
      price: data.row.price,
    });
    setOpen(true);
  };

  // Close the modal form
  const handleClose = () => {
    setOpen(false);
  };

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setCar({...car, [event.target.name]: event.target.value});
  };

  // Update car and close modal form
  const handleSave = () => {
    updateCar(car, data.id);
    handleClose();
  };

  return (
    <div>
      <IconButton onClick={handleClickOpen}>
        <EditIcon color="primary" />
      </IconButton>

      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Edit car</DialogTitle>
        <DialogContent>
          <Stack spacing={2} mt={1}>
            <TextField
              label="Brand"
              name="brand"
              autoFocus
              variant="standard"
              value={car.brand}
              onChange={handleChange}
            />
            <TextField label="Model" name="model" variant="standard" value={car.model} onChange={handleChange} />
            <TextField label="Color" name="color" variant="standard" value={car.color} onChange={handleChange} />
            <TextField label="Year" name="year" variant="standard" value={car.year} onChange={handleChange} />
            <TextField label="Price" name="price" variant="standard" value={car.price} onChange={handleChange} />
          </Stack>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={handleSave}>Save</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
